package com.example.petlife.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "age")
    private int age;
    @Column(name = "description", columnDefinition = "text")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pet")
    // все эти свойства принадлежат тому же самому pet, который написан в модели Pet. Создастся еще одно поле с id животного
    // Типа каскада All - при сохранении животного, включающего фотографии, сохранятся будут не только он, но и связанные с ним сущности
    private List<Image> images = new ArrayList<>();
    private Long previewImageId;
    private LocalDateTime dateOfCreated; // дата создания

    public Pet(Long id, String name, String type, int age, String description, List<Image> images, Long previewImageId, LocalDateTime dateOfCreated) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.age = age;
        this.description = description;
        this.images = images;
        this.previewImageId = previewImageId;
        this.dateOfCreated = dateOfCreated;
    }

    public Pet() {
    }

    @PrePersist //метод инициализации, инвесряи управления внетренней зависимостью
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }

    public void addImageToPet(Image image) {
        image.setPet(this);
        images.add(image);
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public int getAge() {
        return this.age;
    }

    public String getDescription() {
        return this.description;
    }

    public List<Image> getImages() {
        return this.images;
    }

    public Long getPreviewImageId() {
        return this.previewImageId;
    }

    public LocalDateTime getDateOfCreated() {
        return this.dateOfCreated;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void setPreviewImageId(Long previewImageId) {
        this.previewImageId = previewImageId;
    }

    public void setDateOfCreated(LocalDateTime dateOfCreated) {
        this.dateOfCreated = dateOfCreated;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Pet)) return false;
        final Pet other = (Pet) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        if (this.getAge() != other.getAge()) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$images = this.getImages();
        final Object other$images = other.getImages();
        if (this$images == null ? other$images != null : !this$images.equals(other$images)) return false;
        final Object this$previewImageId = this.getPreviewImageId();
        final Object other$previewImageId = other.getPreviewImageId();
        if (this$previewImageId == null ? other$previewImageId != null : !this$previewImageId.equals(other$previewImageId))
            return false;
        final Object this$dateOfCreated = this.getDateOfCreated();
        final Object other$dateOfCreated = other.getDateOfCreated();
        if (this$dateOfCreated == null ? other$dateOfCreated != null : !this$dateOfCreated.equals(other$dateOfCreated))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Pet;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        result = result * PRIME + this.getAge();
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $images = this.getImages();
        result = result * PRIME + ($images == null ? 43 : $images.hashCode());
        final Object $previewImageId = this.getPreviewImageId();
        result = result * PRIME + ($previewImageId == null ? 43 : $previewImageId.hashCode());
        final Object $dateOfCreated = this.getDateOfCreated();
        result = result * PRIME + ($dateOfCreated == null ? 43 : $dateOfCreated.hashCode());
        return result;
    }

    public String toString() {
        return "Pet(id=" + this.getId() + ", name=" + this.getName() + ", type=" + this.getType() + ", age=" + this.getAge() + ", description=" + this.getDescription() + ", images=" + this.getImages() + ", previewImageId=" + this.getPreviewImageId() + ", dateOfCreated=" + this.getDateOfCreated() + ")";
    }
//    private String author;
}
