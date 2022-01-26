package fr.sylvainjanet.personal_website.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.sylvainjanet.personal_website.dto.entities.MenuDto;
import fr.sylvainjanet.personal_website.entities.Menu;
import fr.sylvainjanet.personal_website.repositories.MenuRepository;
import fr.sylvainjanet.personal_website.services.interfaces.IMenuService;

@Service
@Transactional
public class MenuService extends GenericService<Menu, MenuDto> implements IMenuService {

	public MenuService(@Autowired MenuRepository menuRepository) {
		super(MenuDto.class, menuRepository);
	}

}
