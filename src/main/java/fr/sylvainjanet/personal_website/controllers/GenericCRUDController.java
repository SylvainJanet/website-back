package fr.sylvainjanet.personal_website.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import fr.sylvainjanet.personal_website.constants.api.uri.PublicUriCRUD;
import fr.sylvainjanet.personal_website.dto.entities.EntityDto;
import fr.sylvainjanet.personal_website.dto.entities.ListEntityDto;
import fr.sylvainjanet.personal_website.entities.MyEntity;
import fr.sylvainjanet.personal_website.services.IGenericService;

public class GenericCRUDController<T extends MyEntity, TDto extends EntityDto> implements IGenericCRUDController {

	protected IGenericService<TDto> tService;

	@Autowired
	public GenericCRUDController(IGenericService<TDto> tService) {
		this.tService = tService;
	}

	@GetMapping(value = PublicUriCRUD.GETALL, produces = "application/json")
	public ResponseEntity<?> getAll() {
		List<TDto> lst = tService.getAll();
		ListEntityDto<TDto> lstDto = new ListEntityDto<TDto>(lst);
		return ResponseEntity.status(HttpStatus.OK).body(lstDto);
	}
}
