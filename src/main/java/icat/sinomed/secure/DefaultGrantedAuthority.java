package icat.sinomed.secure;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by liucong on  16-4-5-005.
 */
class Authority implements GrantedAuthority{

    public static final Authority READ = new Authority("READ");
    public static final Authority WRITE = new Authority("WRITE");

    private final String authority;

    private Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
