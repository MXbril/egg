export default interface Product {
    id: string;
    title: string;
    description?: string;
    price: number;
    quantity?: number;
    units?: number;
    onsale?: boolean;
    images: Array<string>;
    colors: Array<string>;
  }