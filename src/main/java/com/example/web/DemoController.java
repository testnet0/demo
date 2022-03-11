package com.example.web;

import org.springframework.web.bind.annotation.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import java.util.Hashtable;

/**
 * @className DemoController
 * @author Leaf.wang@tuya.com
 * @date 2022/3/11 2:22 下午
 * @version v1.0
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
@RestController
@RequestMapping("/test")
public class DemoController {
    @GetMapping("/demo")
    public void jndiLookup(HttpServletRequest request) throws NamingException {
        String name = request.getParameter("name");
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
        env.put(Context.PROVIDER_URL, "rmi://trusted-server:1099");
        InitialContext ctx = new InitialContext(env);

        ctx.lookup(name);
    }
}
