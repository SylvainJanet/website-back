package fr.sylvainjanet.personal_website.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.sylvainjanet.personal_website.constants.api.uri.PublicUri;
import fr.sylvainjanet.personal_website.controllers.interfaces.ILanguagedStringController;
import fr.sylvainjanet.personal_website.dto.entities.LanguagedStringDto;
import fr.sylvainjanet.personal_website.entities.LanguagedString;
import fr.sylvainjanet.personal_website.services.interfaces.ILanguagedStringService;

@RestController
@RequestMapping(PublicUri.LANGUAGED_STRING_CONTROLLER)
public class LanguagedStringController extends GenericCRUDController<LanguagedString, LanguagedStringDto>
		implements ILanguagedStringController {

	public LanguagedStringController(@Autowired ILanguagedStringService languagedStringService) {
		super(languagedStringService);
	}

}
