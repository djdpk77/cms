package spring_five.cms.domain.resources;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_five.cms.domain.models.Category;
import spring_five.cms.domain.vo.CategoryRequest;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/category")
@Tag(name = "Category",description = "Category API")
public class CategoryResource {

    @GetMapping(value = "/{id}")
    @Operation(summary = "Find category",description = "Find the category by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Category Found"),
            @ApiResponse(responseCode = "404",description = "Category not Found")
    })
    public ResponseEntity<Category> findOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(new Category());
    }

    @GetMapping
    @Operation(summary = "List categories", description = "List all categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Categories found"),
            @ApiResponse(responseCode = "404",description = "Category not found")
    })
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(Arrays.asList(new Category(), new Category()));
    }

    @PostMapping
    @Operation(summary = "Create category",description = "It permits to create a new category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Category created successfully"),
            @ApiResponse(responseCode = "400",description = "Invalid Request")
    })
    public ResponseEntity<Category> newCategory(CategoryRequest category){
        return new ResponseEntity<>(new Category(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Remove category", description = "It permits to remove a category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Category removed successfully"),
            @ApiResponse(responseCode = "404",description = "Category not found")
    })
    public void removeCategory(@PathVariable("id") String id) {

    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Category",description = "It permits to update a category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Category updated successfully"),
            @ApiResponse(responseCode = "404",description = "Category not found"),
            @ApiResponse(responseCode = "400",description = "Invalid request")
    })
    public ResponseEntity<Category> updateCategory(@PathVariable("id") String id, CategoryRequest category) {
        return new ResponseEntity<>(new Category(), HttpStatus.OK);
    }
}
