package id.app.amira.migrasidata.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.app.amira.migrasidata.model.DatatablesResponse;
import id.app.amira.migrasidata.model.Lokasi;
import id.app.amira.migrasidata.service.IMigrasiDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping(value = {"/api", "/"})
public class MigrasiDataController {

    @Value("${baseUrl}")
    protected String baseUrl;

    @Autowired
    IMigrasiDataService service;

    @RequestMapping(value = {"/", "/index"})
    public String index(Model model) {
        model.addAttribute("baseUrl", baseUrl);
        return "index";
    }

    @RequestMapping(value = {"simkeu/all-datatable"}, method = RequestMethod.POST, produces = "application/json")
    public void getDataTables(
            @RequestParam("draw") int draw,
            @RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "length", defaultValue = "10") int length,
            @RequestParam(value = "search[value]", defaultValue = "") String search,
            @RequestParam("thnAng") String thnAng,
            @RequestParam("lokasi") String lokasi,
            HttpServletResponse response) {
        DatatablesResponse datatablesResponse = service.getDataTable(draw, start, length, search, thnAng, lokasi);
        setJsonResponse(datatablesResponse, response);
    }

    @RequestMapping(value = {"simkeu/get-all-thn-ang"}, produces = "application/json")
    public void selectTahunAnggaran(HttpServletResponse response) {
        List<String> thnAng = service.selectTahunAnggaran();
        setJsonResponse(thnAng, response);
    }

    @RequestMapping(value = {"simkeu/get-all-lokasi"}, produces = "application/json")
    public void selectLokasi(HttpServletResponse response) {
        List<Lokasi> lokasi = service.selectLokasi();
        setJsonResponse(lokasi, response);
    }

    @RequestMapping(value = {"simkeu/migrasi-data"}, method = RequestMethod.POST)
    public void MigrasiData(@RequestParam("thnAng") String thnAng, @RequestParam("lokasi") String lokasi, HttpServletResponse response) {
        service.migrasiData(thnAng, lokasi);
        service.migrasiJenisTransaksi();
        service.migrasiKpknl();
        service.migrasiKppn();
        service.migrasiUpb();
        service.migrasiSskel();

        setJsonResponse(service.createViewMasterU(), response);
//        setJsonResponse(0, response);
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
