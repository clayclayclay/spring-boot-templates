package com.max.security.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Class File:AuthenticationUtil
 * Author: Max
 * Created Date: 2017-12-06
 */
public class AuthenticationUtil
{

    public static String getAuthenticatedUsername()
    {
        String username = null;
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        if (principal instanceof UserDetails)
        {
            username = ((UserDetails) principal).getUsername();
        }
        else
        {
            username = principal.toString();
        }
        return username;
    }

}
