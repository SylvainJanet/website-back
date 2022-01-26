package fr.sylvainjanet.personal_website.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.sylvainjanet.personal_website.constants.api.uri.PublicUri;
import fr.sylvainjanet.personal_website.controllers.interfaces.ILocalizedStringController;
import fr.sylvainjanet.personal_website.dto.entities.LocalizedStringDto;
import fr.sylvainjanet.personal_website.entities.LocalizedString;
import fr.sylvainjanet.personal_website.services.interfaces.ILocalizedStringService;

@RestController
@RequestMapping(PublicUri.LOCALIZED_STRING_CONTROLLER)
public class LocalizedStringController extends GenericCRUDController<LocalizedString, LocalizedStringDto>
		implements ILocalizedStringController {

	public LocalizedStringController(@Autowired ILocalizedStringService localizedStringService) {
		super(localizedStringService);
	}

}
