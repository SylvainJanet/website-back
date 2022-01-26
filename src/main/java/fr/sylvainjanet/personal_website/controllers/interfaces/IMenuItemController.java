package fr.sylvainjanet.personal_website.controllers.interfaces;

import org.springframework.http.ResponseEntity;

import fr.sylvainjanet.personal_website.controllers.IGenericCRUDController;

public interface IMenuItemController extends IGenericCRUDController {

	ResponseEntity<?> getAllLevel1();

	ResponseEntity<?> getAllLevel2();
}
