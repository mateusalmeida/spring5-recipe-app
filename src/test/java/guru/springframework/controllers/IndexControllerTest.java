package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class IndexControllerTest {

    IndexController controller;

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @Before
    public void setUp()  throws Exception{
        MockitoAnnotations.initMocks(this);

        controller = new IndexController(recipeService);
    }


    @Test
    public void getIndexPage()  throws Exception {

       String viewName  =  controller.getIndexPage(model);

       assertEquals(viewName ,"index");
       verify(recipeService, times(1)).getRecipes();
       verify(model,times(1)).addAttribute(eq("recipes"), anySet());
    }

}