package com.sw5.spring.travel.plan.service;

import com.sw5.spring.travel.domain.plan.DetailedPlan;
import com.sw5.spring.travel.domain.plan.DetailedPlanRepository;
import com.sw5.spring.travel.domain.plan.Plan;
import com.sw5.spring.travel.domain.plan.PlanRepository;
import com.sw5.spring.travel.plan.converter.PlanConverter;
import com.sw5.spring.travel.plan.dto.DetailedPlanDto;
import com.sw5.spring.travel.plan.dto.PlanDto;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.springframework.data.domain.Pageable;

@Slf4j
@Service
public class PlanServiceImpl implements PlanService{
    private final PlanRepository planRepository;
    private final DetailedPlanRepository detailedPlanRepository;
    private final PlanConverter planConverter;

    @Autowired
    public PlanServiceImpl(PlanRepository planRepository, DetailedPlanRepository detailedPlanRepository, PlanConverter planConverter) {
        this.planRepository = planRepository;
        this.detailedPlanRepository = detailedPlanRepository;
        this.planConverter = planConverter;
    }

    @Transactional
    public Long savePlan(PlanDto planDto) { //이후에 일행도 여기서 같이 저장?
        // dto -> entity
        Plan plan = planConverter.convertPlan(planDto);
        // persistence
        Plan entity = planRepository.save(plan);

        return entity.getId();
    }

    @Transactional
    public Long saveDetailedPlan(DetailedPlanDto detailedPlanDto) {
        // dto -> entity
        DetailedPlan detailedPlan = planConverter.convertDetailedPlan(detailedPlanDto);
        //persistence
        DetailedPlan entity = detailedPlanRepository.save(detailedPlan);

        return entity.getId();
    }

    @Transactional
    public Page<PlanDto> findAllPlan(Pageable pageable) {
        return planRepository.findAll(pageable)
                .map(planConverter::convertPlanDto);
    }

    @Transactional
    public PlanDto findOne(Long id) throws NotFoundException {
        return planRepository.findById(id)
                .map(planConverter::convertPlanDto)
                .orElseThrow(() -> new NotFoundException("cannot find plan"));
    }

    @Transactional
    public Page<DetailedPlanDto> findAllDetailedPlan(Pageable pageable) {
        return detailedPlanRepository.findAll(pageable)
                .map(planConverter::convertDetailedPlanDto);
    }
}
