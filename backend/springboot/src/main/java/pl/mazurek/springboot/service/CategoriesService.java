package pl.mazurek.springboot.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mazurek.springboot.entity.Categories;
import pl.mazurek.springboot.repo.CategoriesRepo;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoriesService {

    private final CategoriesRepo categoriesRepo;
    private final ObjectMapper mapper;


    public List<Categories> findAll() {
        return categoriesRepo.findAll();
    }

    public void save(Categories categories) {
        categoriesRepo.save(categories);
    }

    public void fillFromJson() {
        File file = new File("backend/springboot/src/main/java/pl/mazurek/springboot/category.json");

        try {
            List<Categories> categories = mapper.readValue(file, new TypeReference<>() {});
            for (Categories category : categories) {
                save(category);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
