package br.com.literacode.service;

public interface IConvertData {
    <T> T getConvertedData(String json, Class<T> classe);
}
