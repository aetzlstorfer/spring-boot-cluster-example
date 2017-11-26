package org.mufuku.dockercluster.web.controller;

import org.mufuku.dockercluster.backend.facade.TodoListFacade;
import org.mufuku.dockercluster.backend.facade.dto.NewTodoListEntryDTO;
import org.mufuku.dockercluster.backend.facade.dto.TodoListEntryDTO;
import org.mufuku.dockercluster.web.controller.form.TodoListEntryForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Andreas Etzlstorfer (a.etzlstorfer@gmail.com)
 */
@Controller
@RequestMapping("/todoList")
public class TodoListController {

    private final TodoListFacade todoListFacade;

    public TodoListController(TodoListFacade todoListFacade) {
        this.todoListFacade = todoListFacade;
    }

    @GetMapping("/items")
    public String itemsGET(Model model) {
        List<TodoListEntryDTO> entries = todoListFacade.getEntries();
        model.addAttribute("entries", entries);
        return "todoList/items";
    }

    @PostMapping("/createItem")
    public String createItemPOST(@ModelAttribute TodoListEntryForm form) {

        NewTodoListEntryDTO dto = new NewTodoListEntryDTO();
        dto.setTitle(form.getTitle());

        todoListFacade.addEntry(dto);

        return "redirect:/todoList/items";
    }

    @GetMapping("/items/{id}/remove")
    public String removeItemGET(@PathVariable Long id) {
        todoListFacade.remove(id);
        return "redirect:/todoList/items";
    }

    @GetMapping("/items/{id}/done")
    public String setDoneGET(@PathVariable Long id) {
        todoListFacade.setDone(id);
        return "redirect:/todoList/items";
    }

}
