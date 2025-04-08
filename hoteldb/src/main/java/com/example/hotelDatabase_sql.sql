-- ========================
-- DROP TABLES IF THEY EXIST
-- ========================
DROP TABLE IF EXISTS Booking;
DROP TABLE IF EXISTS Amenities;
DROP TABLE IF EXISTS Hotel;

-- ========================
-- CREATE TABLES
-- ========================

CREATE TABLE Hotel (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    address VARCHAR(200),
    region VARCHAR(100),
    availableRooms INT,
    ratings INT
);

CREATE TABLE Booking (
    bookingId INT PRIMARY KEY,
    hotelId INT,
    guestName VARCHAR(100),
    fromDate DATE,
    toDate DATE,
    FOREIGN KEY (hotelId) REFERENCES Hotel(id)
);

CREATE TABLE Amenities (
    hotelId INT PRIMARY KEY,
    spa BOOLEAN,
    breakfast BOOLEAN,
    transport BOOLEAN,
    gym BOOLEAN,
    swimmingPool BOOLEAN,
    daycare BOOLEAN,
    restaurant BOOLEAN,
    miniBar BOOLEAN,
    roomService BOOLEAN,
    bar BOOLEAN,
    wifi BOOLEAN,
    washingMachine BOOLEAN,
    FOREIGN KEY (hotelId) REFERENCES Hotel(id)
);

-- ========================
-- INSERT HOTEL DATA
-- ========================

INSERT INTO Hotel VALUES
(1, 'Blue Lagoon Retreat', 'Nordurljosavegur 9, 240 Grindavík', 'Suðurnes', 15, 5),
(2, 'Hotel Borg', 'Pósthússtræti 11, 101 Reykjavík', 'Höfuðborgarsvæði', 10, 4),
(3, 'Fosshotel Glacier Lagoon', 'Hnappavellir, 785 Öræfi', 'Austurland', 8, 5),
(4, 'Hótel Egilsen', 'Aðalgata 2, 340 Stykkishólmur', 'Vesturland', 6, 4),
(5, 'ION Adventure Hotel', 'Nesjavellir, 805 Þingvellir', 'Suðurland', 12, 3),
(6, 'Skuggi Hotel', 'Hverfisgata 103, 101 Reykjavík', 'Höfuðborgarsvæði', 20, 4),
(7, 'Hótel Búðir', 'Búðir, 356 Snæfellsnes', 'Vesturland', 5, 5),
(8, 'Seljalandsfoss Horizons', 'Þórsmerkurvegur, 861 Hvolsvöllur', 'Suðurland', 9, 3),
(9, 'Northern Lights Inn', 'Nordurljósabraut 1, 240 Grindavík', 'Suðurnes', 7, 4),
(10, 'Hótel Laki', 'Road 204, Efri-Vík, 880 Kirkjubæjarklaustur', 'Austurland', 11, 3);

-- ========================
-- INSERT BOOKING DATA
-- ========================

INSERT INTO Booking VALUES
(1, 1, 'Anna Jónsdóttir', '2025-07-01', '2025-07-05'),
(2, 1, 'Bjarni Sigurðsson', '2025-07-10', '2025-07-12'),
(3, 2, 'Sara Magnúsdóttir', '2025-06-20', '2025-06-25'),
(4, 3, 'Elías Guðmundsson', '2025-08-01', '2025-08-07'),
(5, 3, 'Karen Stefánsdóttir', '2025-08-10', '2025-08-15'),
(6, 4, 'Jónina Ragnarsdóttir', '2025-05-05', '2025-05-08'),
(7, 5, 'Þórður Björnsson', '2025-07-15', '2025-07-20'),
(8, 6, 'María Kristjánsdóttir', '2025-09-01', '2025-09-05'),
(9, 7, 'Ólafur Tryggvason', '2025-07-20', '2025-07-23'),
(10, 8, 'Helga Björnsdóttir', '2025-08-10', '2025-08-12'),
(11, 9, 'Gunnar Elíasson', '2025-06-15', '2025-06-18'),
(12, 10, 'Ragnheiður Árnadóttir', '2025-07-05', '2025-07-10');

-- ========================
-- INSERT AMENITIES DATA
-- ========================

INSERT INTO Amenities VALUES
(1, TRUE, TRUE, FALSE, TRUE, FALSE, FALSE, TRUE, FALSE, FALSE, TRUE, TRUE, FALSE),
(2, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE),
(3, FALSE, TRUE, FALSE, TRUE, TRUE, FALSE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE),
(4, FALSE, TRUE, FALSE, FALSE, FALSE, FALSE, TRUE, FALSE, TRUE, TRUE, TRUE, FALSE),
(5, TRUE, TRUE, TRUE, TRUE, FALSE, FALSE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE),
(6, TRUE, TRUE, FALSE, TRUE, FALSE, FALSE, TRUE, FALSE, TRUE, TRUE, TRUE, TRUE),
(7, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE),
(8, FALSE, FALSE, FALSE, TRUE, FALSE, FALSE, FALSE, FALSE, FALSE, TRUE, FALSE, FALSE),
(9, TRUE, TRUE, FALSE, FALSE, FALSE, TRUE, TRUE, TRUE, FALSE, TRUE, TRUE, FALSE),
(10, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, FALSE, FALSE, TRUE, TRUE, TRUE);
