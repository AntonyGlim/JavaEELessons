package glim.antony.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Project {
    private String title;
    private String description;
    private LocalDate timeStart;
}
