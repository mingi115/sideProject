<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>모여라모여~</title>
    <script src="https://cdn.jsdelivr.net/npm/ol@v7.2.2/dist/ol.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/ol@v7.2.2/ol.css">
    <link rel="stylesheet" type="text/css" href="/css/common.css">
    <link rel="stylesheet" type="text/css" href="/css/range.css">
</head>
<body>

    <div id="map">
        <div id="list-wrapper">
            <button type="button" id="feature-list-btn">△</button>
            <label for="range-input">주행거리<input id="range-input" value="3" type="number" />KM</label>
            <div id="feature-list">
                <ol>

                </ol>
            </div>
        </div>
    </div>
    <script src="/js/common/common.js"></script>
</body>
</html>
