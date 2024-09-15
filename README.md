<h1>Delivery Service Management System</h1>

<p>This project is a backend service developed using <strong>Java Spring Boot</strong>, <strong>Spring Data JPA</strong>, and <strong>MySQL</strong>. It implements a delivery service management system where multiple delivery types, such as Standard, Express, and Same Day delivery, can be selected based on the package's weight, distance, and urgency.</p>

<h2>Project Overview</h2>
<ul>
    <li><strong>Technology Stack:</strong> Java, Spring Boot, Spring Data JPA, MySQL</li>
    <li><strong>Pattern Used:</strong> Factory Pattern to dynamically choose the delivery service based on package properties.</li>
</ul>

<h2>Core Features</h2>
<ul>
    <li><strong>Calculate Delivery Cost and Time:</strong> Calculates the cost and estimated delivery time based on the package's weight, distance, and delivery type.</li>
    <li><strong>Deliver Package:</strong> Delivers the package according to the selected delivery type and prints confirmation.</li>
    <li><strong>Optimized Delivery:</strong> Automatically selects the best delivery option based on criteria such as distance and weight.</li>
</ul>

<h2>Key Components</h2>
<ul>
    <li><strong>Controller:</strong> The <code>DeliveryController</code> handles incoming API requests for calculating delivery cost, delivering packages, and optimizing delivery based on weight and distance.</li>
    <li><strong>Factory:</strong> The <code>DeliveryServiceFactory</code> dynamically selects the appropriate delivery service (Standard, Express, or SameDay) based on the delivery type or package details.</li>
    <li><strong>Service Implementations:</strong> The project contains service implementations for different delivery types:
        <ul>
            <li><code>StandardDeliveryService</code>: Handles standard delivery with a lower cost and longer delivery time.</li>
            <li><code>ExpressDeliveryService</code>: Provides faster delivery at a higher cost.</li>
            <li><code>SameDayDeliveryService</code>: Offers same-day delivery for nearby locations at a premium rate.</li>
        </ul>
    </li>
    <li><strong>Entity:</strong> The <code>DeliveryPackage</code> entity stores details about each package, including weight, distance, cost, and delivery time, in the database.</li>
</ul>

<h2>Database</h2>
<p>The project uses <strong>MySQL</strong> as the database to store delivery package details. It interacts with the database using Spring Data JPA for easy CRUD operations.</p>

<h2>Getting Started</h2>
<p>To run this project locally, clone the repository, configure your MySQL database, and run the Spring Boot application. Make sure to update the <code>application.properties</code> file with your database credentials.</p>
