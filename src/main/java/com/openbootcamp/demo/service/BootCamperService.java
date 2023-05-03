package com.openbootcamp.demo.service;

import com.openbootcamp.demo.models.BootCamper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service

public class BootCamperService {

    private List<BootCamper> bootcampers = new ArrayList();

    public  List<BootCamper> getAll(){
        return bootcampers;
    }

    public void add(BootCamper bootcamper) {
        bootcampers.add(bootcamper);
    }

    public BootCamper get(String nombre) {
        for (BootCamper bootcamper : bootcampers) {
            if (bootcamper.getNombre().equalsIgnoreCase(nombre)) {
                return bootcamper;
            }
        }

        return null;
    }
}
