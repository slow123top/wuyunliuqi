package icat.sinomed.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

/**
 * Created by liucong on  16-4-2-002.
 */
@Component
public class 节气工具 {
    private static final ZoneOffset ZONE_OFFSET_8 = ZoneOffset.ofHours(8);
    private List<Long> epochSecondList;
    private int firstSolarTermValueOffset;

    @Autowired
    ApplicationContext context;

    @Value("${app.sinomed.SolarTermTimeTablePath}")
    String solarTermTimeTablePath;

    @PostConstruct
    private void postConstruct() {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        final Resource resource = context.getResource(solarTermTimeTablePath);
        try {
            final InputStream    solarTermInputStream = resource.getInputStream();
            final BufferedReader solarTermReader      = new BufferedReader(new InputStreamReader(solarTermInputStream, Charset.forName("UTF-8")));
            final List<String>   solarTermsTableLines = solarTermReader.lines().collect(Collectors.toList());
            final String         firstTermName        = solarTermsTableLines.get(0).substring(19, 21);
            final 节气             first节气              = 节气.valueOf(firstTermName);
            firstSolarTermValueOffset = first节气.getIntValue();
            epochSecondList = solarTermsTableLines.stream().map(s -> {
                final String        dateTime    = s.substring(0, 19);
                final LocalDateTime date        = LocalDateTime.parse(dateTime, dateTimeFormatter);
                final long          epochSecond = date.toEpochSecond(ZONE_OFFSET_8);
                return epochSecond;
            }).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public 节气 getSolarTerm(LocalDateTime time) {
        final long epochSecond = time.toEpochSecond(ZONE_OFFSET_8);
        final int  i           = Collections.binarySearch(epochSecondList, epochSecond);
        int        solarTermIndex;
        if (i >= 0) {
            solarTermIndex = i;
        } else {
            solarTermIndex = -1 - i - 1;
        }

        int solarTermValue = solarTermIndex + firstSolarTermValueOffset;
        solarTermValue = solarTermValue % 24;
        if (solarTermValue == 0) {
            solarTermValue = 24;
        }
        return 节气.fromIntValue(solarTermValue);
    }
}
