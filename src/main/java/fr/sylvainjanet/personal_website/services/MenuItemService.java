package fr.sylvainjanet.personal_website.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.sylvainjanet.personal_website.dto.entities.MenuItemDto;
import fr.sylvainjanet.personal_website.dto.entities.partial.MenuItemDtoLevel1;
import fr.sylvainjanet.personal_website.dto.entities.partial.MenuItemDtoLevel2;
import fr.sylvainjanet.personal_website.dto.tools.DtoTools;
import fr.sylvainjanet.personal_website.entities.MenuItem;
import fr.sylvainjanet.personal_website.repositories.MenuItemRepository;
import fr.sylvainjanet.personal_website.services.interfaces.IMenuItemService;

@Service
@Transactional
public class MenuItemService extends GenericService<MenuItem, MenuItemDto> implements IMenuItemService {

	public MenuItemService(@Autowired MenuItemRepository menuItemRepository) {
		super(MenuItemDto.class, menuItemRepository);
	}

	@Override
	public List<MenuItemDtoLevel1> getAllLevel1() {
		List<MenuItem> lst = tRepository.findAll();
		List<MenuItemDtoLevel1> result = new ArrayList<MenuItemDtoLevel1>();
		for (MenuItem t : lst) {
			result.add(DtoTools.convert(t, MenuItemDtoLevel1.class));
		}
		return result;
	}

	@Override
	public List<MenuItemDtoLevel2> getAllLevel2() {
		List<MenuItem> lst = tRepository.findAll();
		List<MenuItemDtoLevel2> result = new ArrayList<MenuItemDtoLevel2>();
		for (MenuItem t : lst) {
			result.add(DtoTools.convert(t, MenuItemDtoLevel2.class));
		}
		return result;
	}

}
