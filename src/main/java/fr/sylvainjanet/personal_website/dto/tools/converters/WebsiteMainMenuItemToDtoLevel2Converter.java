package fr.sylvainjanet.personal_website.dto.tools.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.AbstractConverter;

import fr.sylvainjanet.personal_website.dto.entities.LanguagedStringDto;
import fr.sylvainjanet.personal_website.dto.entities.WebPageCategoryMainDto;
import fr.sylvainjanet.personal_website.dto.entities.partial.WebsiteMainMenuItemDtoLevel1;
import fr.sylvainjanet.personal_website.entities.WebsiteMainMenuItem;

public class WebsiteMainMenuItemToDtoLevel2Converter
		extends AbstractConverter<List<WebsiteMainMenuItem>, List<WebsiteMainMenuItemDtoLevel1>> {

	@Override
	protected List<WebsiteMainMenuItemDtoLevel1> convert(List<WebsiteMainMenuItem> input) {

		WebsiteMainMenuItemToDtoLevel1Converter conv = new WebsiteMainMenuItemToDtoLevel1Converter();

		return input.stream()
				.map(wsmi -> new WebsiteMainMenuItemDtoLevel1((int) wsmi.getId(), wsmi.getVersion(),
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