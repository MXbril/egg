import ProductProp from "../interfaces/ProductProp";


function Descripción(props: ProductProp) {
  const { product } = props;
  return (
    <>
      <div className="w-[340px] p-[10px] m-[10px] flex flex-col">
        <h1 className="text-[28px] font-bold mt-0 text-wrap">{product.title}</h1>
        <form className="mt-[30px]">
          <fieldset className="border-0 p-0 flex flex-col">
            <label className="text-[12px] font-bold" htmlFor="color">
              Color
            </label>
            <select className="w-full h-[40px] bg-white rounded-[10px] border-1 border[#eaeaea] m-0 mt-[10px] p-[10px] box-border" id="color">
              {product.colors.map((each) => (
                <option key={each} value="Silver">{each}</option>
              ))} 
            </select>
          </fieldset>
        </form>
        <div className="mt-[30px]">
          <span className="text-[12px] font-bold">Descripción</span>
          <p className="text-[12px]">
            {product.description}
          </p>
        </div>
      </div>
    </>
  );
}

export default Descripción;
