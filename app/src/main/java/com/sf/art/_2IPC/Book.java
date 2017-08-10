/**
 * @author: songfei
 * @Title:Book.java
 * @Description: 
 * @DATE: 2017-8-4上午8:45:35
 * 
 */
package com.sf.art._2IPC;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable, Serializable {
    private static final long serialVersionUID = 7387675273143270720L;
    private int bookId;
    private String bookName;
    public static final long id = 1L;

    public Book(int id, String bookname) {
	this.bookId = id;
	this.bookName = bookname;
    }

    @Override
    public String toString() {
	return "[" + "bookId=" + bookId + "，" + "bookName=" + bookName + "]";
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
	dest.writeInt(bookId);
	dest.writeString(bookName);
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
	@Override
	public Book createFromParcel(Parcel source) {
	    return new Book(source);
	}

	@Override
	public Book[] newArray(int size) {
	    return new Book[size];
	}
    };

    private Book(Parcel in) {
	in.readInt();
	in.readString();
    }

    @Override
    public int describeContents() {
	return 0;
    }
}
