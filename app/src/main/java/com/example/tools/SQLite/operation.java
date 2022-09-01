package com.example.tools.SQLite;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;
@Table(name = "op")
public class operation {
        @Column(name = "id", isId = true)
        private int id;
        @Column(name="type")
        private int type;

        @Column(name = "date")
        private String date;

        @Column(name = "title")
        private String title;

        @Column(name = "read")
        private int read;
        @Column(name = "email")
        private String email;
        @Column(name ="choice")
        private int choice;

        public  int getChoice()
        {
            return choice;
        }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public  String getEmail()
    {
        return email;
    }
        public void setEmail(String email)
        {
            this.email=email;
        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date=date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title=title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }

        @Override
        public String toString() {
            return "operation{" +
                    "id=" + id +
                    ", type='"+type+'\''+
                    ", date='" + date + '\'' +
                    ", title='" + title + '\'' +
                    ", read=" + read +
                    '}';
        }
    }

