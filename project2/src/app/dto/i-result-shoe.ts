export interface IResultShoe<T> {
  content: T[];
  pagination: {
    pageNumber: number,
    size: number
  };
  shoeTotalElements: number;
}
