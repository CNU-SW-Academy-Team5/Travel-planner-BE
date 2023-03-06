package com.sw5.spring.travel.plan.controller;

import com.sw5.spring.travel.plan.ApiResponse;
import com.sw5.spring.travel.plan.dto.DetailedPlanDto;
import com.sw5.spring.travel.plan.dto.PlanDto;
import com.sw5.spring.travel.plan.dto.UserDto;
import com.sw5.spring.travel.plan.dto.UserLoginDto;
import com.sw5.spring.travel.plan.service.PlanServiceImpl;
import com.sw5.spring.travel.plan.service.UserServiceImpl;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlanController {
    PlanServiceImpl planServiceImpl;

    UserServiceImpl userService;

    @Autowired
    public PlanController(PlanServiceImpl planServiceImpl, UserServiceImpl userService) {
        this.planServiceImpl = planServiceImpl;
        this.userService = userService;
    }

    @ExceptionHandler(NotFoundException.class)
    public ApiResponse<String> notFoundHandler (NotFoundException e) {
        return ApiResponse.fail(404, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<String> internalServerErrorHandler (Exception e) {
        return ApiResponse.fail(500, e.getMessage());
    }

    @PostMapping("/plan")
    public ApiResponse<Long> savePlan(@RequestBody PlanDto planDto) {
        Long id = planServiceImpl.savePlan(planDto);

        return ApiResponse.ok(id);
    }

    @PostMapping("/detailed-plan")
    public ApiResponse<Long> saveDetailedPlan(@RequestBody DetailedPlanDto detailedPlanDto) {
        Long id = planServiceImpl.saveDetailedPlan(detailedPlanDto);

        return ApiResponse.ok(id);
    }

    @GetMapping("/plan/{id}")
    public ApiResponse<PlanDto> getPlanById(@PathVariable Long id) throws NotFoundException {
        PlanDto one = planServiceImpl.findOne(id);
        return ApiResponse.ok(one);
    }

    @GetMapping("/plan-list")
    public ApiResponse<Page<PlanDto>> getAllPlan(Pageable pageable) {
        Page<PlanDto> all = planServiceImpl.findAllPlan(pageable);

        return ApiResponse.ok(all);
    }

    @GetMapping("/detailed-plan-list")
    public ApiResponse<Page<DetailedPlanDto>> getAllDetailedPlan(Pageable pageable) {
        Page<DetailedPlanDto> all = planServiceImpl.findAllDetailedPlan(pageable);
        return ApiResponse.ok(all);
    }
    
    @GetMapping("/login")
    public ApiResponse<String> login(@RequestBody UserLoginDto loginDto){
        String userId = userService.login(loginDto);
        return ApiResponse.ok(userId);
    }

    @GetMapping("/user-name/{userName}")
    public ApiResponse<UserDto> getUserByName(@PathVariable String userName) throws NotFoundException {
        UserDto user = userService.findOneUser(userName);
        return ApiResponse.ok(user);
    }

    @PostMapping("/signup")
    public ApiResponse<String> saveUser(@RequestBody UserDto userDto){
        String userId = userService.saveUser(userDto);
        return ApiResponse.ok(userId);
    }
}