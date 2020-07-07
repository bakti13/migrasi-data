package id.app.amira.migrasidata.controller;

import id.app.amira.migrasidata.model.MasterU;
import id.app.amira.migrasidata.service.IMigrasiDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MigrasiDataController {
    @Autowired
    IMigrasiDataService service;

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        model.addAttribute("title", "Hello World!!");
        return "index";
    }

    @RequestMapping(value = {"/api/simkeu"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MasterU> getTopFiveDataSimkeu() {
        return service.selecAllDataSimkeu();
//        return simkeuDao.selectTopFiveDataSimkeu();
    }

    @GetMapping(value = "/views")
    public ModelAndView showCities() {

        List<MasterU> master = service.selecAllDataSimkeu();
        List<MasterU> amira = service.selecAllDataAmira();

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("masters", master);
        params.put("aMasters", amira);

        return new ModelAndView("views/views2", params);
    }

    @GetMapping(value = "/migrasi")
    public ModelAndView migrasiData() {

//        List<MasterU>  master = service.selecAllDataSimkeu();
        service.migrasiData("2010");

        List<MasterU> amira = service.selecAllDataAmira();

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("masters", new ArrayList<MasterU>());
        params.put("aMasters", amira);

        return new ModelAndView("views/views2", params);
    }
}
