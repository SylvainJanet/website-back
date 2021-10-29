package fr.sylvainjanet.personal_website.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import fr.sylvainjanet.personal_website.entities.MyEntity;

@NoRepositoryBean
public interface IGenericRepository<T extends MyEntity> extends JpaRepository<T, Long> {

}