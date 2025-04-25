package asdrubal.hr.visulal_v1.classes_auxiliares;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConvertStringIdsToListInteger {
    public List<Integer> converte(String ids) {
        String[] d = ids.split("#");
        List<Integer> lista = new ArrayList<>();
        for (String s : d) {
            if (!s.isEmpty()) {
                lista.add(Integer.parseInt(s));
            }
        }
        Collections.sort(lista);
        return lista;
    }
}
