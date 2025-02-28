INSERT INTO currencies (currency_code, currency_name, symbol, base_currency, exchange_rate, is_active, region, creator_id, creator_name, modified_time, modifier_id, modifier_name)
VALUES
('USD', 'US Dollar', '$', 'USD', 1.0000, TRUE, 'United States', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('EUR', 'Euro', '€', 'USD', 1.1000, TRUE, 'European Union', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('GBP', 'British Pound', '£', 'USD', 1.2500, TRUE, 'United Kingdom', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('JPY', 'Japanese Yen', '¥', 'USD', 0.0072, TRUE, 'Japan', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('INR', 'Indian Rupee', '₹', 'USD', 0.0120, TRUE, 'India', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('AUD', 'Australian Dollar', 'A$', 'USD', 0.7000, TRUE, 'Australia', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('CAD', 'Canadian Dollar', 'C$', 'USD', 0.7500, TRUE, 'Canada', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('CHF', 'Swiss Franc', 'CHF', 'USD', 1.0500, TRUE, 'Switzerland', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('CNY', 'Chinese Yuan', '¥', 'USD', 0.1450, TRUE, 'China', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('ZAR', 'South African Rand', 'R', 'USD', 0.0580, TRUE, 'South Africa', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('SGD', 'Singapore Dollar', 'S$', 'USD', 0.7400, TRUE, 'Singapore', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('HKD', 'Hong Kong Dollar', 'HK$', 'USD', 0.1280, TRUE, 'Hong Kong', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('KRW', 'South Korean Won', '₩', 'USD', 0.0008, TRUE, 'South Korea', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('MXN', 'Mexican Peso', '$', 'USD', 0.0520, TRUE, 'Mexico', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('BRL', 'Brazilian Real', 'R$', 'USD', 0.2000, TRUE, 'Brazil', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('RUB', 'Russian Ruble', '₽', 'USD', 0.0130, TRUE, 'Russia', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('SEK', 'Swedish Krona', 'kr', 'USD', 0.0950, TRUE, 'Sweden', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('NOK', 'Norwegian Krone', 'kr', 'USD', 0.0970, TRUE, 'Norway', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('DKK', 'Danish Krone', 'kr', 'USD', 0.1600, TRUE, 'Denmark', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('PLN', 'Polish Zloty', 'zł', 'USD', 0.2400, TRUE, 'Poland', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('NZD', 'New Zealand Dollar', 'NZ$', 'USD', 0.6500, TRUE, 'New Zealand', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('TRY', 'Turkish Lira', '₺', 'USD', 0.0370, TRUE, 'Turkey', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('AED', 'UAE Dirham', 'د.إ', 'USD', 0.2723, TRUE, 'United Arab Emirates', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('SAR', 'Saudi Riyal', '﷼', 'USD', 0.2667, TRUE, 'Saudi Arabia', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('THB', 'Thai Baht', '฿', 'USD', 0.0286, TRUE, 'Thailand', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('MYR', 'Malaysian Ringgit', 'RM', 'USD', 0.2400, TRUE, 'Malaysia', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('IDR', 'Indonesian Rupiah', 'Rp', 'USD', 0.000065, TRUE, 'Indonesia', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('VND', 'Vietnamese Dong', '₫', 'USD', 0.000043, TRUE, 'Vietnam', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('PHP', 'Philippine Peso', '₱', 'USD', 0.0180, TRUE, 'Philippines', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('EGP', 'Egyptian Pound', '£', 'USD', 0.0320, TRUE, 'Egypt', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('KWD', 'Kuwaiti Dinar', 'د.ك', 'USD', 3.2800, TRUE, 'Kuwait', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('BHD', 'Bahraini Dinar', 'د.ب', 'USD', 2.6500, TRUE, 'Bahrain', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('OMR', 'Omani Rial', '﷼', 'USD', 2.6000, TRUE, 'Oman', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('QAR', 'Qatari Riyal', '﷼', 'USD', 0.2747, TRUE, 'Qatar', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('PKR', 'Pakistani Rupee', '₨', 'USD', 0.0035, TRUE, 'Pakistan', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('LKR', 'Sri Lankan Rupee', '₨', 'USD', 0.0032, TRUE, 'Sri Lanka', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('NGN', 'Nigerian Naira', '₦', 'USD', 0.0013, TRUE, 'Nigeria', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('GHS', 'Ghanaian Cedi', '₵', 'USD', 0.0860, TRUE, 'Ghana', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('TWD', 'New Taiwan Dollar', 'NT$', 'USD', 0.0320, TRUE, 'Taiwan', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('ARS', 'Argentine Peso', '$', 'USD', 0.0030, TRUE, 'Argentina', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('UAH', 'Ukrainian Hryvnia', '₴', 'USD', 0.0270, TRUE, 'Ukraine', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('HUF', 'Hungarian Forint', 'Ft', 'USD', 0.0028, TRUE, 'Hungary', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('CZK', 'Czech Koruna', 'Kč', 'USD', 0.0430, TRUE, 'Czech Republic', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('RON', 'Romanian Leu', 'lei', 'USD', 0.2100, TRUE, 'Romania', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('CLP', 'Chilean Peso', '$', 'USD', 0.0013, TRUE, 'Chile', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('PEN', 'Peruvian Sol', 'S/', 'USD', 0.2600, TRUE, 'Peru', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('COP', 'Colombian Peso', '$', 'USD', 0.00023, TRUE, 'Colombia', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin'),
('BDT', 'Bangladeshi Taka', '৳', 'USD', 0.0093, TRUE, 'Bangladesh', 1, 'Admin', CURRENT_TIMESTAMP, 1, 'Admin');
