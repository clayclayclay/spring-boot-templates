
package com.max.aspectJ;

import com.max.springaop.service.AdminService;
import com.max.springaop.service.AdminServiceImpl;

public class AspectJClient
{

    public static void main(String[] args)
    {
        AdminService adminService = new AdminServiceImpl();
        adminService.login(null, null);
    }
}
