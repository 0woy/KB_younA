package org.scoula.config;


import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;


public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    final String LOCATION = "C:/upload";
    final long MAX_FILE_SIZE = 1024 * 1024 * 10L; // 10M
    final long MAX_REQUEST_SIZE = 1024 * 1024 * 20L; // 20M
    final int FILE_SIZE_THRESHOLD = 1024 * 1024 * 5; // 5M
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{Rootconfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletConfig.class, SwaggerConfig.class};
    }

    // Spring의 DispathcerServlet이 담당할 Url 매핑 패턴
    @Override
    protected String[] getServletMappings() {
        return new String[]{
                "/",
                "/swagger-ui.html",
                "/swagger-resources/**",
                "/v2/api-docs",
                "/webjars/**"
        };
    }

    // POST body 문자 인코딩 필터 설정
    protected Filter[] getServletFilters(){
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();

        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        return new Filter[]{characterEncodingFilter};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
        // 파일 업로드 설정
        MultipartConfigElement multipartConfig = new MultipartConfigElement(
                LOCATION, // 업로드 처리 디렉토리 경로
                MAX_FILE_SIZE, // 업로드 가능한 파일 하나의 최대 크기
                MAX_REQUEST_SIZE, // 업로드 가능한 전체 최대 크기(여러 파일 업로드 하는 경우)
                FILE_SIZE_THRESHOLD // 메모리 파일의 최대 크기(이보다 작으면 실제 메모리에서만 작업)
        );
        registration.setMultipartConfig(multipartConfig);
    }


}
