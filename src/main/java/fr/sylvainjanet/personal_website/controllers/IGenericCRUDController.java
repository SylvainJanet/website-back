package fr.sylvainjanet.personal_website.controllers;

import org.springframework.http.ResponseEntity;

public interface IGenericCRUDController {

	ResponseEntity<?> getAll();

//		ResponseEntity<?> getAllByPage(@PathVariable(PublicUriCRUD.GETALLBYPAGE_PAGE) int page, @PathVariable(PublicUriCRUD.GETALLBYPAGE_SIZE) int size);
//
//		ResponseEntity<?> getById(@PathVariable(PublicUriCRUD.GETBYID_ID) long id);
//
//		ResponseEntity<?> save(@RequestBody TDto dto);
//
//		ResponseEntity<?> update(@RequestBody TDto dto);
//
//		ResponseEntity<?> deleteById(@PathVariable(value = PublicUriCRUD.DELETEBYID_ID, required = true) long id);
//
//		ResponseEntity<?> count();
//
//		ResponseEntity<?> getAllOrderedBy(Integer page, Integer size, Map<String, String> requestParams) throws Exception;
//
//		ResponseEntity<?> findByKeyWord(Integer page, Integer size, Map<String, String> requestParams);
//		
//		ResponseEntity<?> countByKeyWord(@RequestParam final Map<String, String> requestParams);
}