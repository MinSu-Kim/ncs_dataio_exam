package ncs_dataio_exam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ContextDataSource.class, ContextSqlSession.class})
@ComponentScan(basePackages = {
        "ncs_dataio_exam.mapper",
        "ncs_dataio_exam.controller",
        "ncs_dataio_exam.service"})
public class ContextRoot {

}
