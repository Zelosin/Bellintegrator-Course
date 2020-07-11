package com.zelosin.bellproject.util;

public class Transfer {
    public interface Save{}
    public interface Update{}
    public interface Filter{}

    public interface ListView{}
    public interface DetailView extends ListView{};
}
