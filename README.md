# Link Cutter 

[![](https://img.shields.io/badge/release-1.1.0-blue.svg)](https://github.com/latidude99/enquiries/tree/master/release)
[![License: GPL v3](https://img.shields.io/badge/license-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
[![GitHub issues](https://img.shields.io/badge/issues-open%200-greenred.svg)](https://GitHub.com/latidude99/enquiries/issues/)
[![](https://img.shields.io/badge/%20$%20-buy%20me%20a%20coffe-yellow.svg)](https://www.buymeacoffee.com/zWn1I6bVf)

Link shortening service  
  
# General Info
A quick Spring Boot exercise.  
Creates a short link that redirect to the original URL address. Allows to specify number of days the link will remain valid. Also, gives an option to delete the link with a pin code (generated alongside the link).   

Info page displays:
- the original URL address
- the short link
- number of times the link was used
- status of the link: ACTIVE/EXPIRED/DELETED
- time when the link expired/ was deleted

A cleanup job removing expired links is scheduled to take place every minute (can be changed in `application.properties` modifying the `cron.expression` property)

### side note
The app uses an in-memory H2 database but it can be easily switched to any SQL DB by changing connection and driver properties in the `application.properties` file.
There is also a very basic version of the service using a HashMap instead of a database, remainder of the first mock-up, includes classes: `RandomIdentifierGenerator`, `LinkDTO`, `LinkService`, `LinkRepository`, `InMemoryMapLinkRepo` and `MapController`. Classes `HomeController` and `Link` are shared with the H2 version)
	

# Screenshots

<p align="center">
  <img src="images/home.JPG" width=100%></p>
  <br>
<p align="center">
  <img src="images/short.JPG" width=100%></p>
  <br>
<p align="center">
	<img src="images/error.JPG" width=100%> </p>
  <br>
<p align="center">
	<img src="images/expired.JPG" width=100%></p>
   <br>
 <p align="center">
	<img src="images/deleted.JPG" width=100%></p>
</p>

# Status

Development


# Technologies
- Spring Boot 2.1.6
- Java JDK 8
- Maven 3.60
- H2 1.4.193
- Thymeleaf 3.0.11
- IntelliJ IDEA



# License
Link Cutter is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License 
as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
Link Cutter is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied 
warranty of  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
You should have received a copy of the GNU General Public License along with Link Cutter. 
If not, see http://www.gnu.org/licenses/ or write to: latidude99@gmail.com

# Contact
You can email me at latidude99@gmail.com
