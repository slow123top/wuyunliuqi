package icat.sinomed.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import icat.sinomed.entity.APIResponse;

/**
 * Created by liucong on  16-4-12-012.
 */
@Controller
//@RequestMapping("${server.error.path:${error.path:/error}}")
public class ApplicationErrorController extends BasicErrorController {

    @Autowired
    public ApplicationErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes, new ErrorProperties());
    }

    @ResponseBody
    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {

        Map<String, Object> body = getErrorAttributes(request,
                isIncludeStackTrace(request, MediaType.ALL));
        HttpStatus status = getStatus(request);

        final APIResponse errorResponse = new APIResponse((String) body.get("error"),
                APIResponse.Status.ERROR, status.toString());


        final HashMap<String, Object> r = new HashMap<>();
        r.put("message", errorResponse.getMessage());
        r.put("code", errorResponse.getCode());
        r.put("status", errorResponse.getStatus());
        r.put("data", errorResponse.getData());

        return new ResponseEntity<>(r, status);

    }
}
