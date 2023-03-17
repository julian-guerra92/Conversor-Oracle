package com.oracle.conversor.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Longitud {
    public static final Map<String, String> measurementUnits;
    public static final Map<String, Double> equivalencies;

    static {

        measurementUnits = new HashMap<>();
        measurementUnits.put("km", "Kilómetro");
        measurementUnits.put("m", "Metro");
        measurementUnits.put("dm", "Decímetro");
        measurementUnits.put("cm", "Centímetro");
        measurementUnits.put("mm", "Milímetro");
        measurementUnits.put("µm", "Micrómetro");
        measurementUnits.put("nm", "Nanómetro");
        measurementUnits.put("Å", "Angstrom");

        equivalencies = new HashMap<>();
        equivalencies.put("km-km", 1.0);
        equivalencies.put("km-m", 1000.0);
        equivalencies.put("km-dm", 10000.0);
        equivalencies.put("km-cm", 100000.0);
        equivalencies.put("km-mm", 1000000.0);
        equivalencies.put("km-µm", 1000000000.0);
        equivalencies.put("km-nm", 1000000000000.0);
        equivalencies.put("km-Å", 10000000000000.0);

        equivalencies.put("m-km", 0.001);
        equivalencies.put("m-m", 1.0);
        equivalencies.put("m-dm", 10.0);
        equivalencies.put("m-cm", 100.0);
        equivalencies.put("m-mm", 1000.0);
        equivalencies.put("m-µm", 1000000.0);
        equivalencies.put("m-nm", 1000000000.0);
        equivalencies.put("m-Å", 10000000000.0);

        equivalencies.put("dm-km", 0.0001);
        equivalencies.put("dm-m", 0.1);
        equivalencies.put("dm-dm", 1.0);
        equivalencies.put("dm-cm", 10.0);
        equivalencies.put("dm-mm", 100.0);
        equivalencies.put("dm-µm", 100000.0);
        equivalencies.put("dm-nm", 100000000.0);
        equivalencies.put("dm-Å", 1000000000.0);

        equivalencies.put("cm-km", 0.00001);
        equivalencies.put("cm-m", 0.01);
        equivalencies.put("cm-dm", 0.1);
        equivalencies.put("cm-cm", 1.0);
        equivalencies.put("cm-mm", 10.0);
        equivalencies.put("cm-µm", 10000.0);
        equivalencies.put("cm-nm", 10000000.0);
        equivalencies.put("cm-Å", 100000000.0);

        equivalencies.put("mm-km", 0.000001);
        equivalencies.put("mm-m", 0.001);
        equivalencies.put("mm-dm", 0.01);
        equivalencies.put("mm-cm", 0.1);
        equivalencies.put("mm-mm", 1.0);
        equivalencies.put("mm-µm", 1000.0);
        equivalencies.put("mm-nm", 1000000.0);
        equivalencies.put("mm-Å", 10000000.0);

        equivalencies.put("µm-km", 0.000000001);
        equivalencies.put("µm-m", 0.000001);
        equivalencies.put("µm-dm", 0.00001);
        equivalencies.put("µm-cm", 0.0001);
        equivalencies.put("µm-mm", 0.001);
        equivalencies.put("µm-µm", 1.0);
        equivalencies.put("µm-nm", 1000.0);
        equivalencies.put("µm-Å", 10000.0);

        equivalencies.put("nm-km", 0.000000000001);
        equivalencies.put("nm-m", 0.000000001);
        equivalencies.put("nm-dm", 0.00000001);
        equivalencies.put("nm-cm", 0.0000001);
        equivalencies.put("nm-mm", 0.000001);
        equivalencies.put("nm-µm", 0.001);
        equivalencies.put("nm-nm", 1.0);
        equivalencies.put("nm-Å", 10.0);

        equivalencies.put("Å-km", 0.0000000000001);
        equivalencies.put("Å-m", 0.0000000001);
        equivalencies.put("Å-dm", 0.000000001);
        equivalencies.put("Å-cm", 0.00000001);
        equivalencies.put("Å-mm", 0.0000001);
        equivalencies.put("Å-µm", 0.0001);
        equivalencies.put("Å-nm", 0.1);
        equivalencies.put("Å-Å", 1.0);
    }

}
