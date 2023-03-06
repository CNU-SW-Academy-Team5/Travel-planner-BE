package com.sw5.spring.travel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sw5.spring.travel.domain.plan.Region;
import com.sw5.spring.travel.plan.dto.DetailedPlanDto;
import com.sw5.spring.travel.plan.dto.PlanDto;
import com.sw5.spring.travel.plan.service.PlanServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureRestDocs
@AutoConfigureMockMvc
@SpringBootTest
@TestPropertySource("classpath:application-test.yml")
@ExtendWith(RestDocumentationExtension.class)
public class IntegrationTest {
    private final PlanServiceImpl planService;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper;


    @Autowired
    public IntegrationTest(PlanServiceImpl planService, MockMvc mockMvc, ObjectMapper objectMapper) {
        this.planService = planService;
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .build();
    }

    @Test
    void savePlanTest() throws Exception {
        //Given
        PlanDto planDto = PlanDto.builder()
                .name("제주도 여행")
                .startDate(LocalDate.of(2023, 03, 03))
                .endDate(LocalDate.of(2023, 03, 05))
                .region(Region.JEJU)
                .createdAt(LocalDateTime.now())
                .lastEdited(LocalDateTime.now())
                .detailedPlansDtos(List.of(
                        DetailedPlanDto.builder()
                                .startTime(LocalDateTime.of(2023, 03, 03, 13, 00))
                                .endTime(LocalDateTime.of(2023, 03, 03, 15, 00))
                                .location("연돈")
                                .address("제주특별자치도 서귀포시 특별자치도, 일주서로 968-10")
                                .memo("점심 식사")
                                .createdAt(LocalDateTime.now())
                                .lastEdited(LocalDateTime.now())
                                .build()
                        , DetailedPlanDto.builder()
                                .startTime(LocalDateTime.of(2023, 03, 04, 18, 00))
                                .endTime(LocalDateTime.of(2023, 03, 04, 19, 00))
                                .location("흑돼지")
                                .address("제주특별자치도 제주시")
                                .memo("저녁 식사")
                                .createdAt(LocalDateTime.now())
                                .lastEdited(LocalDateTime.now())
                                .build()
                ))
                .build();

        //When //Then
        mockMvc.perform(post("/plan")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(planDto)))
                .andExpect(status().isOk())
                .andDo(print())
                .andDo(document("plan-save"));
    }

}
