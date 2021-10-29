package fr.sylvainjanet.personal_website.dto.tools.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.AbstractConverter;

import fr.sylvainjanet.personal_website.dto.entities.LanguagedStringDto;
import fr.sylvainjanet.personal_website.dto.entities.WebPageCategoryMainDto;
import fr.sylvainjanet.personal_website.dto.entities.WebsiteMainMenuItemDto;
import fr.sylvainjanet.personal_website.entities.WebsiteMainMenuItem;

public class WebsiteMainMenuItemToDtoLevel1Converter
		extends AbstractConverter<List<WebsiteMainMenuItem>, List<WebsiteMainMenuItemDto>> {

	@Override
	protected List<WebsiteMainMenuItemDto> convert(List<WebsiteMainMenuItem> input) {

		WebsiteMainMenuItemToDtoConverter conv = new WebsiteMainMenuItemToDtoConverter();

		return input.stream()
				.map(wsmi -> new WebsiteMainMenuItemDto((int) wsmi.getId(), wsmi.getVersion(),
						conv.convert(wsmi.getSubitems()),
						new WebPageCategoryMainDto((int) wsmi.getWebpageCategoryMain().getId(),
								wsmi.getWebpageCategoryMain().getVersion(),
								new LanguagedStringDto((int) wsmi.getWebpageCategoryMain().getTitle().getId(),
										wsmi.getWebpageCategoryMain().getTitle().getVersion(),
										wsmi.getWebpageCategoryMain().getTitle().getStrings()),
								new LanguagedStringDto((int) wsmi.getWebpageCategoryMain().getContent().getId(),
										wsmi.getWebpageCategoryMain().getContent().getVersion(),
										wsmi.getWebpageCategoryMain().getContent().getStrings())),
						new LanguagedStringDto((int) wsmi.getLanguagedTitle().getId(),
								wsmi.getLanguagedTitle().getVersion(), wsmi.getLanguagedTitle().getStrings())))
				.collect(Collectors.toList());
	}
}
