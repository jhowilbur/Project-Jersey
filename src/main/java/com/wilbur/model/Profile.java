package com.wilbur.model;

import java.util.Date;

public class Profile
{
    private Long id;
    private String name;
    private String firstName;
    private String lastName;
    private Date created;

    public Profile(){}

    public Profile(Long id, String name, String firstName, String lastName)
    {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = new Date();
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Date getCreated()
    {
        return created;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }
}
