package id.app.amira.migrasidata.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.app.amira.migrasidata.model.DatatablesResponse;
import id.app.amira.migrasidata.service.IMigrasiDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class MigrasiDataController {
    @Autowired
    IMigrasiDataService service;

    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = {"/api/simkeu/all-datatable"}, method = RequestMethod.POST, produces = "application/json")
    public void getTopFiveDataSimkeu(
            @RequestParam("draw") int draw,
            @RequestParam("start") int start,
            @RequestParam("length") int length,
            @RequestParam(value = "search[value]", defaultValue = "") String search,
            @RequestParam("thnAng") String thnAng,
            HttpServletResponse response) {
        DatatablesResponse datatablesResponse = service.getDataTable(draw, start, length, search, thnAng);
        setJsonResponse(datatablesResponse, response);
    }

    @RequestMapping(value = {"/api/simkeu/get-all-thn-ang"}, produces = "application/json")
    public void selectTahunAnggaran(HttpServletResponse response) {
        List<String> thnAng = service.selectTahunAnggaran();
        setJsonResponse(thnAng, response);
    }

    @RequestMapping(value = {"/api/simkeu/migrasi-data"}, method = RequestMethod.POST)
    public void MigrasiData(@RequestParam("thnAng") String thnAng, HttpServletResponse response) {
        service.migrasiData(thnAng);
        setJsonResponse(0, response);
    }

    private void setJsonResponse(Object object, HttpServletResponse response) {
        try {
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = mapper.writeValueAsString(object);

            out.print(jsonInString);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
