package org.mufuku.dockercluster.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Andreas Etzlstorfer (a.etzlstorfer@gmail.com)
 */
@RestController
public class StatusController {

    @RequestMapping("/status")
    @ResponseBody
    public Map<String, String> indexGET() throws UnknownHostException {
        String hostName = InetAddress.getLocalHost().getHostName();
        Map<String, String> result = new HashMap<>();
        result.put("hostName", hostName);
        return result;
    }
}
