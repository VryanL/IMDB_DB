# IMDb_Data_API (beta)

This is a work in progress IMDb data API, at the moment /api/basics/episodes?title={title} returns 10(default) episodes of {title}. 

## Features
* PostgresSQL database with index's for faster search
* IMDb updated on 15 Feb 2025

## Usage
*GET localhost:8080/api/basics/episodes?title={title}&page={}&size={}