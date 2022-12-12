import {IProductType} from './i-product-type';
import {IProducer} from './i-producer';

export interface IBadmintonDto {
id?: number;
name?: string;
dateOfManufacture?: string;
image?: string;
content?: string;
price?: number;
promotion?: string;
productType?: IProductType[];
producer?: IProducer[];
}
