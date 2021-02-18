package io.work02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Klass {
    
    List<Student> students;
    
    public void dong(){
        System.out.println(this.getStudents());
    }
    
}
