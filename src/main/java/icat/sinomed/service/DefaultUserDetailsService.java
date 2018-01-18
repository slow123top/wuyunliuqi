package icat.sinomed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import icat.sinomed.entity.User;
import icat.sinomed.repository.UserRepository;

/**
 * Created by liucong on  16-4-5-005.
 */

@Service("icatUaserDetailsService")
@Transactional(readOnly = true)
public class DefaultUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("用户未找到");
        }
        return user;
    }
}
