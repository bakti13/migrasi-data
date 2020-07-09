package id.app.amira.migrasidata.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
public class DatatablesResponse {
    @Setter
    @Getter
    private int draw;

    @Setter
    @Getter
    private int recordsTotal;

    @Setter
    @Getter
    private int recordsFiltered;

    @Setter
    @Getter
    private List data;
}
