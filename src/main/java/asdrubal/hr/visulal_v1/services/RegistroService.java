package asdrubal.hr.visulal_v1.services;

import asdrubal.hr.visulal_v1.dto.Registro_DTO;
import asdrubal.hr.visulal_v1.entities.Registro;
import asdrubal.hr.visulal_v1.repositories.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistroService {
    @Autowired
    private RegistroRepository registroRepository;

    public Registro_DTO criaRegistro(Registro_DTO rDTO) {
        Registro registro = preparaRegistroInicial(rDTO);
        registro = registroRepository.save(registro);
        rDTO.setIdRegistro(registro.getIdRegistro());
        return rDTO;
    }

    private Registro preparaRegistroInicial(Registro_DTO rDTO) {
        Registro registro = new Registro();
        registro.setIdPrograma(rDTO.getIdPrograma());
        registro.setIdPareo(rDTO.getIdPareo());
        registro.setHipoData(rDTO.getHipoData());
        registro.setRaia(rDTO.getRaia());
        return registro;
    }
}
