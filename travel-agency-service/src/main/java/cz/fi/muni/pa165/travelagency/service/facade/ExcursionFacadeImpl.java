
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.fi.muni.pa165.travelagency.service.facade;

import cz.fi.muni.pa165.travelagency.dto.ExcursionDTO;
import cz.fi.muni.pa165.travelagency.entity.Excursion;
import cz.fi.muni.pa165.travelagency.facade.ExcursionFacade;
import cz.fi.muni.pa165.travelagency.service.DozerMapperService;
import cz.fi.muni.pa165.travelagency.service.ExcursionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Julius Stassik
 */

@Service
@Transactional
public class ExcursionFacadeImpl implements ExcursionFacade {

    @Autowired
    private ExcursionService excursionService;
    
    @Autowired
    private DozerMapperService dozerMapperService;
    
    @Override
    public void create(ExcursionDTO excursion) {
        if(excursion == null){
            throw new IllegalArgumentException("param excursion is null");
        }
        
        Excursion exc = dozerMapperService.mapTo(excursion, Excursion.class);
        excursionService.create(exc);
    }

    @Override
    public void delete(Long id) {
        if(id == null){
            throw new IllegalArgumentException("param id is null");
        } else if (excursionService.getById(id) == null){
            throw new IllegalArgumentException("desired excursion doesnt exist");
        }
        
        excursionService.delete(excursionService.getById(id));
        
    }

    @Override
    public void update(ExcursionDTO excursion) {
        if(excursion == null){
            throw new IllegalArgumentException("param excursion is null");
        } else if (excursionService.getById(excursion.getId()) == null){
            throw new IllegalArgumentException("desired excursion doesnt exist");
        }
        
        Excursion mappedExcursion = dozerMapperService.mapTo(excursion, Excursion.class);
        excursionService.update(mappedExcursion);
    }

    @Override
    public ExcursionDTO getById(Long id) {
        if(id == null){
            throw new IllegalArgumentException("param id is null");
        } else if (excursionService.getById(id) == null){
            throw new IllegalArgumentException("desired excursion doesnt exist");
        }
        
        return dozerMapperService.mapTo(excursionService.getById(id), ExcursionDTO.class);
    }

    @Override
    public List<ExcursionDTO> getAll() {
        return dozerMapperService.mapTo(excursionService.getAll(), ExcursionDTO.class);
    }
    
}
